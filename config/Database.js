import {Sequelize} from "sequelize";

const host = process.env.host

const db = new Sequelize("painthings", "root", '', {
    host: host,
    dialect: "mysql"
});

export default db;