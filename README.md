# javafetch
One of the slowest programs to display system information. Written in Java.

## Execution times
My machine:
- CPU: Intel Core i5-10400F 2.9GHz
- RAM: 16GB 2400MHz/2666Mhz (I don't really know)
- Disk: NVMe SSD 500GB
- OS: Artix Linux
- JRE Version: 17

Average javafetch execution time on my machine: 0.22s

## Supported platforms
- Artix Linux
- Arch Linux
- Devuan GNU/Linux
- Gentoo Linux (without package counter)
- Fedora Linux

## Building my worst project
### Installing my worst project dependencies:

#### Arch/Artix/Manjaro/Endeavour:

        # run as root of course
        pacman -S wmname jdk17-openjdk

#### Devuan/Debian/Mint/Ubuntu:

        # run as root of course
        apt install openjdk-17-jdk suckless-tools

#### Gentoo Linux:

        # run as root of course
        # don't forget to set as many optimizations as you can
        emerge -a openjdk-bin wmname


### To build my worst project type:

        ./build.sh

## Installing my worst project

        # if you use doas
        doas ./install.sh

        # if you use sudo
        sudo ./install.sh

## Running the worst fetch

        javafetch


### Some information
- No additional libraries are needed
