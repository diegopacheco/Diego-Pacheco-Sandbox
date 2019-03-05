const bodyParser = require("body-parser");
const cors = require("cors");

const express = require("express");
const port = 9000;
const app = express();

const { ApolloServer, gql } = require("apollo-server-express");

const typeDefs = gql`
    type Query{
        greeting: String
    }
`;

const resolvers = {
    Query: {
        greeting: () => "Hello World Graphql apollo-express",
    },
};

const server = new ApolloServer({
    typeDefs: typeDefs,
    resolvers,
});

app.use(cors(), bodyParser.json());
server.applyMiddleware({app, path: '/graphql'});
app.listen(port, () => console.log(`Server running on http://localhost:${port}`));


