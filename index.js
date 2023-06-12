import express from "express";
import cors from "cors";
import session from "express-session";
import cookieParser from "cookie-parser";
import dotenv from "dotenv";
import db from "./config/Database.js";
import SequelizeStore from "connect-session-sequelize";
import UserRoute from "./routes/UserRoute.js";
import PostRoute from "./routes/PostRoute.js";
import AuthRoute from "./routes/AuthRoute.js";
import ArtRoute from "./routes/ArtRoute.js";
dotenv.config();

const app = express();

const sessionStore = SequelizeStore(session.Store);

const store = new sessionStore({
    db: db
});


app.use(session({
    secret: process.env.SESS_SECRET,
    resave: false,
    saveUninitialized: true,
    store: store,
    cookie: {
        secure: 'auto'
    }
}));

app.use(cors({
    credentials: true
    // origin: 'http://localhost:8080'
}));
app.use(cookieParser());
app.use(express.json());
app.use(UserRoute);
app.use(PostRoute);
app.use(AuthRoute);
app.use(ArtRoute);

// (async()=>{
//     await db.sync();
// })();

// store.sync();

const PORT = process.env.PORT || 8000
app.listen(PORT, () => {
    console.log("Server is up and listening on " + PORT)
})