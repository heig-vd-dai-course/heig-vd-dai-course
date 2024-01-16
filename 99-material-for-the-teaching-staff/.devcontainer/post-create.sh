#!/usr/bin/env sh

## Update packages list
sudo apt update

## Install packages to optimize images (jpegoptim, optipng)
sudo apt install --yes jpegoptim optipng

## Install packages to optimize documents (ps2pdf)
sudo apt install --yes ghostscript
