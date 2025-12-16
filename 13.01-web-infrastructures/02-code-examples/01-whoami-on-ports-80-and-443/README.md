# whoami on ports 80 and 443

This [whoami](https://github.com/traefik/whoami) example shows how to access the
whoami server running on ports 80 and 443 on the virtual machine with Docker and
Docker Compose.

This will ensure that the virtual machine is accessible on port 80 and 443.

## Run the example

Start the containers:

```sh
# Start the containers
docker compose up -d
```

Open your browser and go to public IP address of your virtual machine with the
`http` protocol on port 80, for example `http://VIRTUAL_MACHINE_PUBLIC_IP:80`.

You should now be able to access whoami on port 80.

Go to public IP address of your virtual machine with the `http` protocol on port
443, for example `http://VIRTUAL_MACHINE_PUBLIC_IP:443`.

You should now be able to access whoami on port 443.

> [!NOTE]
>
> If you try to access the whoami server on port 443 with the `https` protocol,
> you will get an error because the whoami server does not have a valid HTTPS
> certificate (your browser might completely block the access depending on your
> browser's security settings). This is expected behavior since we have not set
> up HTTPS for the whoami server in this example.
>
> For the time being, you can ignore this error and only validate the access on
> port 80 and 443 with the `http` protocol.

If you do not get the expected results, your virtual machine might not be
configured correctly. Check the previous chapters to ensure that your virtual
machine is correctly configured.
