import {Sequelize} from "sequelize";

const db = new Sequelize('painthings', 'root', '', {
    host: "localhost",
    dialect: "mysql"
});

export default db;