import express from "express";
import { getArtByCluster } from "../controllers/Art.js";

const router = express.Router();

router.get('/art/:cluster', getArtByCluster);

export default router