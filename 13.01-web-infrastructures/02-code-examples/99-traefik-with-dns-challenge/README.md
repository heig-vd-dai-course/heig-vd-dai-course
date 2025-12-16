# Traefik with DNS challenge

## Disclaimer

This configuration was meant to be used in my (Ludovic) personal homelab and I
wanted to share my findings with you if you are interested in doing something
similar.

Therefore, this example is **optional** to follow. It is here to show you how to
use Traefik in a more advanced way and for your own culture.

**I have not tested this configuration and documentation in depth.**. It works
for my personal use case, but it might not be suitable for production
environments. Use it at your own risk.

For more information about my modest setup, please refer to the
[Personal notes](#personal-notes) section.

## Introduction

This configuration is an improvement of the [`traefik`](../02-traefik/README.md)
example. It adds the following features:

- Make use of the
  [DNS challenge](https://doc.traefik.io/traefik/https/acme/#dnschallenge) to
  generate HTTPS certificates, even if Traefik is not publicly accessible.
- Make use of a Basic Authentication middleware to protect the Traefik dashboard
  with a username and password.

## Prerequisites

### Have a domain name ready and a DNS provider that supports the ACME DNS challenge

You must have a domain name ready.

Your DNS provider must support the
[ACME DNS challenge](https://doc.traefik.io/traefik/https/acme/#dnschallenge).
You can find a list of supported DNS providers at
<https://doc.traefik.io/traefik/https/acme/#providers>.

For this example, we will use [Duck DNS](https://duckdns.org/) as our DNS
provider.

### Create/get the API key(s) for the DNS provider

You must create/get the API key(s) for the DNS provider. For DuckDNS, the API
token is displayed on your account page.

### Create the token file

Create a file named `duckdns_access_token.txt` in the `secrets` directory with
the API token of your DuckDNS account.

```sh
# Create the secrets directory
mkdir -p secrets

# Create the auth_users.txt file
echo "YOUR_DUCKDNS_API_TOKEN" > secrets/duckdns_access_token.txt
```

The `duckdns_access_token.txt` file must be created before starting the
containers.

### Create the users file

The Traefik dashboard is protected with a
[`BasicAuth`](https://doc.traefik.io/traefik/middlewares/http/basicauth/)
middleware (more information about basic authentication on Wikipedia at
<https://en.wikipedia.org/wiki/Basic_access_authentication>). You must create a
`auth_users.txt` file with the username and password of the users allowed to
access the Traefik dashboard.

Docker Compose allows the use of
[Docker Secrets](https://docs.docker.com/compose/use-secrets/) to pass sensitive
information to a service.

The [`compose.yaml`](./compose.yaml) file is already configured to use the
`secrets/auth_users.txt` file as a Docker Secret. You must create the
`auth_users.txt` file in the `secrets` directory.

To create the `auth_users.txt` file, you can use the
[`htpasswd`](https://httpd.apache.org/docs/2.4/programs/htpasswd.html) command
line tool. For example, to create a user named `admin` with the password
`admin`, you can run the following command:

```sh
# Create the secrets directory
mkdir -p secrets

# Create the auth_users.txt file
htpasswd -c secrets/auth_users.txt admin
```

`htpasswd` will ask you to enter the password for the user. You can add more
users to the `auth_users.txt` file by running the same command without the `-c`
option.

The `auth_users.txt` file must be created before starting the containers.

## Run the example

### Access the Traefik dashboard

Start the containers on the virtual machine:

```sh
# Start the containers
docker compose up -d
```

Open your browser and go to the fully qualified domain name of the Traefik
service you defined in the `.env` file with the `https` protocol, for example
`https://TRAEFIK_FULLY_QUALIFIED_DOMAIN_NAME`.

A username and password prompt should appear thanks to the `BasicAuth`
middleware. Enter the username and password you defined in the `auth_users.txt`
file.

You should now be able to access the Traefik dashboard with a valid HTTPS
certificate and in a secure way with the help of the `BasicAuth` middleware.

## Advantages of this configuration

The advantages of this configuration reside in the configuration of the Docker
Compose files.

If you compare both solutions, you will notice that only two Let's Encrypt
certificates are generated over the N number of services you have. This is
because we are using a root + wildcard certificates and not a certificate per
service.

You can now add as many services as you want without having to worry about
generating a new certificate for each service.

Using the wildcard certificate, you can even use the same certificate for
services that are not publicly accessible and still use HTTPS on your local
network. Check the [Personal notes](#personal-notes) section for more
information.

## Personal notes

My personal homelab consists of a NAS running
[Proxmox VE](https://www.proxmox.com/en/proxmox-ve) with a few
[LXC](https://linuxcontainers.org/lxc/) containers running under Debian 13.

I do not expose all my services publicly. To access my private services, I use
[WireGuard](https://www.wireguard.com/) to connect to my home network.

I have a domain name registered with [Infomaniak](https://www.infomaniak.com/)
under the name `ld0.ch` that I use for my homelab (the shorter the DNS name, the
less I have to type 😉).

I have a DNS server running
[AdGuard Home](https://github.com/AdguardTeam/AdguardHome) that is used as the
DNS server for my local network.

Using Traefik, I can access all my services with a common fully qualified domain
name.

In my DNS server, I have some DNS entries that points to the IP address of my
homelab (`*.ld0.ch`).

This allows me to access all my services with a subdomain such as
`traefik.ld0.ch` for when I am connected to my home network or `whoami.ld0.ch`
for the public services.

All this setup works quite well for me, but I was interested in having HTTPS
certificates for all my services, even locally. I wanted to keep things simple
without having to manually generate certificates and/or using other tools such
as [mkcert](https://github.com/FiloSottile/mkcert) or moving my homelab to the
cloud or Kubernetes.
