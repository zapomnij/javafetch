#!/usr/bin/env sh

set -e

echo
echo "Installing"
echo

[ -z ${DESTDIR} ] && DESTDIR=/
[ -z ${PREFIX} ] && PREFIX=usr

cd $(dirname "${0}")

if [ ! -f out/javafetch ]; then
    echo "Javafetch hasn't been already built. Building javafetch" > /dev/stderr
    ./build.sh
fi

install -m755 out/javafetch ${DESTDIR}/${PREFIX}/local/bin/javafetch
echo "javafetch has been installed to ${DESTDIR}/${PREFIX}/local/bin/javafetch"

javafetch