# painthings

This project is a backend service for painthings app. It allows users to create and retrieve posts, as well as manage user accounts with different access levels for administrators and regular users.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)


## Getting Started

### Prerequisites

- Node.js
- NPM
- MySQL
- argon2
- connect-session-sequelize
- cookie-parser
- cors
- dotenv
- express
- express-session
- mysql2
- sequelize


### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/setasenarandata/painthings.git
   ```

2. Install the dependencies:

   ```bash
   cd project-folder
   npm install
   ```

3. Set up the database:
   - Create a MySQL database.
   - Update the database configuration in the `.env` file.

4. Start the application:

   ```bash
   npm start
   ```

## Usage

To use the application, you need to send HTTP requests to the provided API endpoints. You can use tools like curl or Postman to interact with the API.

## API Endpoints

### Get All Users

```
GET /users
```

Retrieves all users. Requires authentication and admin access.

### Get User by ID

```
GET /users/:id
```

Retrieves a user by their ID. Requires authentication and admin access.

### Create a User

```
POST /users
```

Creates a new user.

**Request Body Example:**

```json
{
  "name": "John Doe",
  "email": "johndoe@example.com",
  "password": "password123",
  "birthdate": "01-01-1990"
}
```

### User Authentication

#### Login

```
POST /login
```

Authenticates a user and creates a session.

**Request Body Example:**

```json
{
  "email": "johndoe@example.com",
  "password": "password123"
}
```

#### Logout

```
DELETE /logout
```

Destroys the user session and logs out the user.

#### Get Current User

```
GET /me
```

Retrieves the details of the current logged-in user.



### Get All Posts

```
GET /posts
```

Retrieves all posts. Requires authentication.

### Get Post by ID

```
GET /posts/:id
```

Retrieves a post by its ID. Requires authentication.

**Path Parameters:**
- `id`: The id of the users post.

### Create a Post

```
POST /posts
```

Creates a new post. Requires authentication.

**Request Body Example:**

```json
{
  "love": 5,
  "sadness": 2,
  "anger": 3,
  "happiness": 2,
  "disgust": 1,
  "optimism": 3,
  "art_id": "577273feedc2cb3880ca5e94",
  "journal": "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
}
```

### Get Post by Date

```
GET /posts/date/:createdAt
```

Retrieves a post by its creation date. Requires authentication.

**Path Parameters:**
- `createdAT`: The date of the users post.

### Artwork Management

#### Get Artwork by Cluster

```
GET /art/:cluster
```

Retrieves artworks based on a cluster.

**Path Parameters:**

- `cluster`: The cluster of the artwork to retrieve.
