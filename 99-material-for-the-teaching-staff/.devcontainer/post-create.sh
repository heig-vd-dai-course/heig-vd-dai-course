#!/usr/bin/env sh

## Update packages list
sudo apt update

## Install packages to optimize images (jpegoptim, optipng)
sudo apt install --yes jpegoptim optipng

## Install packages to optimize documents (ps2pdf)
sudo apt install --yes ghostscript

## Install Typst
wget https://github.com/typst/typst/releases/download/v0.10.0/typst-x86_64-unknown-linux-musl.tar.xz -O /tmp/typst.tar.xz

sudo tar --extract --file /tmp/typst.tar.xz --strip-components=1 --directory /usr/local/bin

rm /tmp/typst.tar.xz
