import {Sequelize} from "sequelize";

const db = new Sequelize('painthings', 'root', 'strix2107', {
    host: "34.128.117.197",
    dialect: "mysql"
});

export default db;