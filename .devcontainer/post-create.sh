#!/usr/bin/env sh

## Configure Bash aliases
tee -a ~/.bash_aliases > /dev/null <<"EOF"
alias tree='tree --dirsfirst -A -F'
alias jpegoptim='jpegoptim --strip-all --all-progressive'
alias optipng='optipng -o5 -strip all -fix'
EOF

## Install required packages
# Update packages list
sudo apt update

# Install packages to optimize images (jpegoptim, optipng)
sudo apt install --yes jpegoptim optipng

# Install packages to optimize documents (ps2pdf)
sudo apt install --yes ghostscript

# Install network utilities (dig, nslookup, ping, ncat)
sudo apt install --yes dnsutils iputils-ping ncat

# Install Typst
wget https://github.com/typst/typst/releases/download/v0.12.0/typst-x86_64-unknown-linux-musl.tar.xz -O /tmp/typst.tar.xz

sudo tar --extract --file /tmp/typst.tar.xz --strip-components=1 --directory /usr/local/bin

rm /tmp/typst.tar.xz

# ## Install Typst HEIG-VD template

# # Create the directory for the local packages
# mkdir -p ~/.local/share/typst/packages/local

# # Clone the repository
# git clone https://github.com/heig-vd-dai-course/heig-vd-dai-course-evaluation-and-exam-templates.git /tmp/heig-vd-dai-course-evaluation-and-exam-templates

# # Copy the template to the local packages directory
# cp -r /tmp/heig-vd-dai-course-evaluation-and-exam-templates/typst/heig-vd-evaluations-and-exams-template ~/.local/share/typst/packages/local

# # Remove the temporary directory
# rm -rf /tmp/heig-vd-dai-course-evaluation-and-exam-templates
