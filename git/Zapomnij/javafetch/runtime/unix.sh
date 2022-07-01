#!/usr/bin/env sh

if ! which java > /dev/null 2>&1; then
    if ! which ${JVM} > /dev/null 2>&1; then
        echo "Java Runtime Environment is not installed or it hasn't been specified in 'JVM' environment variable" > /dev/stderr
        echo "Installation:" > /dev/stderr
        echo "Arch/Artix/Manjaro/Endeavour: pacman -S jre17-openjdk"
        echo "Debian/Devuan/Ubuntu/Mint: apt install openjdk-17-jre"
        exit 1
    fi
else
    JVM=java
fi

exec ${JVM} ${JAVAFLAGS} -jar $(which ${0}) $*
