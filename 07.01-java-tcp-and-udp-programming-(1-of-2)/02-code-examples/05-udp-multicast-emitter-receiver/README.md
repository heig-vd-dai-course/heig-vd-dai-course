# UDP multicast emitter/receiver example

An example of a UDP multicast emitter/receiver pattern.

> [!WARNING]
>
> You must set the network interface to the one you want to use in the code.
>
> To do so, you can use the following command:
>
> ```sh
> # Get the list of network interfaces
> ip address
> ```
>
> Then, you can set the network interface to the one you want to use in the
> code.

> [!IMPORTANT]
>
> If you are multiple people testing this code on the same network, you might
> receive messages from other people. To avoid this, you can change the
> multicast address in the code to a different one.
>
> This is one of the strengths of UDP multicast. You can decide to subscribe to
> a specific multicast group by using a specific multicast address and only the
> devices subscribed to this multicast group will receive the messages.

Try to start one emitter and one receiver. What can you notice?

Then, start a new receiver. What can you notice?
