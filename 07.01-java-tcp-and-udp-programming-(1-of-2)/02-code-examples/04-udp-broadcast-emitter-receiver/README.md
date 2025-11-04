# UDP broadcast emitter/receiver example

An example of a UDP broadcast emitter/receiver.

> [!WARNING]
>
> You must set the broadcasting network to the one you want to use in the code.
>
> To do so, you can use the following command:
>
> ```sh
> # Get the list of network interfaces
> ip address
> ```
>
> Then, you can set the broadcasting network related to the interface to the one
> you want to use in the code.

> [!IMPORTANT]
>
> If you are multiple people testing this code on the same network, you might
> receive messages from other people. To avoid this, you can change the port
> number in the code to a different one.
>
> This is one of the weaknesses of UDP broadcast. It is not possible to have a
> private broadcast on a network. All the devices on the same network will
> receive the broadcast messages.

Try to start the emitter before the receiver. What can you notice?

Then, restart the emitter after the receiver. What can you notice?
