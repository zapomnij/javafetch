#!/usr/bin/env sh

set -e

echo
echo "Checking build environment"
echo

if ! which javac > /dev/null 2<&1; then
    if ! which ${JAVAC} > /dev/null 2<&1; then
        echo "Java compiler is not installed or it hasn't been specified in 'JAVAC' environment variable" > /dev/stderr
        echo "Installation:" > /dev/stderr
        echo "Arch/Artix/Manjaro/Endeavour: pacman -S jdk17-openjdk" > /dev/stderr
        echo "Debian/Devuan/Ubuntu/Mint: apt install openjdk-17-jdk" > /dev/stderr
        exit 1
    fi
else
    [ -z ${JAVAC} ] && JAVAC=javac
fi

if ! which jar > /dev/null 2<&1; then
    if ! which ${JAR} > /dev/null 2<&1; then
        echo "Java Archive is not installed or it hasn't been specified in 'JAR' environment variable" > /dev/stderr
        echo "Installation:" > /dev/stderr
        echo "Arch/Artix/Manjaro/Endeavour: pacman -S jdk17-openjdk" > /dev/stderr
        echo "Debian/Devuan/Ubuntu/Mint: apt install openjdk-17-jdk" > /dev/stderr
        echo
        echo "Generating jar file has been disabled since now due to missing Java Archive" > /dev/stderr
        export JAR_DIS=1
    fi
else
    [ -z ${JAR} ] && JAR=jar
fi

if ! which wmname > /dev/null 2<&1; then
    echo "wmname not found" > /dev/stderr
    echo "Installation on Arch/Artix/Manjaro/Endeavour: pacman -S wmname" > /dev/stderr
    exit 1
fi

echo
echo "Building"
echo

cd $(dirname "${0}")

if [ -z "${DEST}" ]; then
    DEST=out
    mkdir -p out
fi

echo "Compiling..."
for file in $(find $(pwd)/git -name '*.java' -type f); do
    echo "  > Compiling ${file}"
    ${JAVAC} -d ${DEST} ${file}
done

if [ ! "${JAR_DIS}" = "1" ]; then
    echo
    echo "Generating JAR file"
    jar cvmf manifest.mf javafetch.jar -C ${DEST} .

    mv javafetch.jar ${DEST}
    echo "done: ${DEST}/javafetch.jar"

    if [ ! "${SEMI_NATIVE_DIS}" = "1" ]; then
        echo
        echo "Generating semi-native javafetch program"
        cat git/Zapomnij/javafetch/runtime/unix.sh ${DEST}/javafetch.jar > ${DEST}/javafetch
        chmod +x ${DEST}/javafetch
        echo "done: ${DEST}/javafetch"
    fi
fi