import Art from "../models/ArtModel.js";
import { Sequelize } from "sequelize";

export const getArtByCluster = async(req, res) =>{
    try {
        const { cluster } = req.params;
        const art = await Art.findAll({
            where:{
                Clusters: cluster
            },
            limit: 10,
            attributes:['id', 'Style', 'Category', 'Artist', 'Title'],
            order: Sequelize.literal('RAND()')
        });
        if(!art) return res.status(404).json({msg: "Data tidak ditemukan"});
        let response;
        // if(req.role === "admin"){
        //     response = await Post.findAll({
        //         attributes:['id', 'uuid','love', 'sad', 'anger', 'happiness', 'disgust', 'optimism',
        //         'art_id', 'createdAt'],
        //         where:{
        //             createdAt: createdAt
        //         },
        //         include:[{
        //             model: User,
        //             attributes:['name','email']
        //         }]
        //     });
        // }else{
            response = art;
        // }
        res.status(200).json(response);
    } catch (error) {
        res.status(500).json({msg: error.message});
    }
}
