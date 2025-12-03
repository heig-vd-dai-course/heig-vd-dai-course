# Users API

The users API allows to manage users. It uses the HTTP protocol and the JSON
format.

The API is based on the CRUD pattern. It has the following operations:

- Create a new user.
- Get many users that you can filter by first name and/or last name.
- Get one user by its ID.
- Update a user.
- Delete a user.

Users are also able to login and logout. They can also access their profile to
validate their information using a cookie.

## Endpoints

### Create a new user

- `POST /users`

Create a new user.

#### Request

The request body must contain a JSON object with the following properties:

- `firstName` - The first name of the user.
- `lastName` - The last name of the user.
- `email` - The email address of the user.
- `password` - The password of the user.

#### Response

The response body contains a JSON object with the following properties:

- `id` - The unique identifier of the user.
- `firstName` - The first name of the user.
- `lastName` - The last name of the user.
- `email` - The email address of the user.
- `password` - The password of the user.

#### Status codes

- `201` (Created) - The user has been successfully created.
- `400` (Bad Request) - The request body is invalid.
- `409` (Conflict) - The user already exists.

### Get many users

- `GET /users`

Get many users.

#### Request

The request can contain the following query parameters:

- `firstName` - The first name of the user.
- `lastName` - The last name of the user.

#### Response

The response body contains a JSON array with the following properties:

- `id` - The unique identifier of the user.
- `firstName` - The first name of the user.
- `lastName` - The last name of the user.
- `email` - The email address of the user.
- `password` - The password of the user.

#### Status codes

- `200` (OK) - The users have been successfully retrieved

### Get one user

- `GET /users/{id}`

Get one user by its ID.

#### Request

The request path must contain the ID of the user.

#### Response

The response body contains a JSON object with the following properties:

- `id` - The unique identifier of the user.
- `firstName` - The first name of the user.
- `lastName` - The last name of the user.
- `email` - The email address of the user.
- `password` - The password of the user.

#### Status codes

- `200` (OK) - The user has been successfully retrieved.
- `404` (Not Found) - The user does not exist.

### Update a user

- `PUT /users/{id}`

Update a user by its ID.

#### Request

The request path must contain the ID of the user.

The request body must contain a JSON object with the following properties:

- `firstName` - The first name of the user.
- `lastName` - The last name of the user.
- `email` - The email address of the user.
- `password` - The password of the user.

#### Response

The response body contains a JSON object with the following properties:

- `id` - The unique identifier of the user.
- `firstName` - The first name of the user.
- `lastName` - The last name of the user.
- `email` - The email address of the user.
- `password` - The password of the user.

#### Status codes

- `200` (OK) - The user has been successfully updated.
- `400` (Bad Request) - The request body is invalid.
- `404` (Not Found) - The user does not exist.

### Delete a user

- `DELETE /users/{id}`

Delete a user by its ID.

#### Request

The request path must contain the ID of the user.

#### Response

The response body is empty.

#### Status codes

- `204` (No Content) - The user has been successfully deleted.
- `404` (Not Found) - The user does not exist.

### Login

- `POST /login`

Login a user.

#### Request

The request body must contain a JSON object with the following properties:

- `email` - The email address of the user.
- `password` - The password of the user.

#### Response

The response body is empty. A `user` cookie is set with the ID of the user.

#### Status codes

- `204` (No Content) - The user has been successfully logged in.
- `400` (Bad Request) - The request body is invalid.
- `401` (Unauthorized) - The user does not exist or the password is incorrect.

### Logout

- `POST /logout`

Logout a user.

#### Request

The request body is empty.

#### Response

The response body is empty. The `user` cookie is removed.

#### Status codes

- `204` (No Content) - The user has been successfully logged out.

### Profile

- `GET /profile`

Get the current user (the user that is logged in).

#### Request

The request body is empty.

#### Response

The response body contains a JSON object with the following properties:

- `id` - The unique identifier of the user.
- `firstName` - The first name of the user.
- `lastName` - The last name of the user.
- `email` - The email address of the user.
- `password` - The password of the user.

#### Status codes

- `200` (OK) - The user has been successfully retrieved.
- `401` (Unauthorized) - The user is not logged in.
