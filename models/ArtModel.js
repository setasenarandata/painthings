import { Sequelize } from "sequelize";
import db from "../config/Database.js";
const {DataTypes} = Sequelize;


const Art = db.define('art', {
  Art_imagetitle_love: {
    type: DataTypes.STRING(20),
    allowNull: false
  },
  Art_imagetitle_sadness: {
    type: DataTypes.STRING(20),
    allowNull: false
  },
  Art_imagetitle_anger: {
    type: DataTypes.STRING(20),
    allowNull: false
  },
  Art_imagetitle_happiness: {
    type: DataTypes.STRING(20),
    allowNull: false
  },
  Art_imagetitle_disgust: {
    type: DataTypes.STRING(20),
    allowNull: false
  },
  Art_imagetitle_optimism: {
    type: DataTypes.STRING(20),
    allowNull: false
  },
  Clusters: {
    type: DataTypes.INTEGER,
    allowNull: false
  },
  id: {
    type: DataTypes.STRING(24),
    primaryKey: true,
    allowNull: false
  },
  Style: {
    type: DataTypes.STRING(31),
    allowNull: false
  },
  Category: {
    type: DataTypes.STRING(43),
    allowNull: false
  },
  Artist: {
    type: DataTypes.STRING(39),
    allowNull: false
  },
  Title: {
    type: DataTypes.STRING(138),
    allowNull: false
  },
  Year: {
    type: DataTypes.STRING(16),
    allowNull: false
  },
  Ave_art_rating: {
    type: DataTypes.NUMERIC(5, 2),
    allowNull: false
  }
}, {
  timestamps: false, // If you don't want timestamps
  tableName: 'art' // Specify the table name if different from the model name
});

export default Art;