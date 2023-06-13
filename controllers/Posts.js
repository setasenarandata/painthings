import Post from "../models/PostModel.js";
import User from "../models/UserModel.js";
import {Op} from "sequelize";

export const getPosts = async (req, res) =>{
    try {
        let response;
        if(req.role === "admin"){
            response = await Post.findAll({
                attributes:['id', 'uuid','love', 'sadness', 'anger', 'happiness', 'disgust', 'optimism',
                'art_id', 'journal', 'createdAt'],
                include:[{
                    model: User,
                    attributes:['name','email']
                }]
            });
        }else{
            response = await Post.findAll({
                attributes:['id', 'uuid','love', 'sadness', 'anger', 'happiness', 'disgust', 'optimism',
                'art_id', 'journal', 'createdAt'],
                where:{
                    userId: req.userId
                },
                include:[{
                    model: User,
                    attributes:['name','email']
                }]
            });
        }
        res.status(200).json(response);
    } catch (error) {
        res.status(500).json({msg: error.message});
    }
}

export const getPostByDate = async(req, res) =>{
    try {
        const { createdAt } = req.params;
        const post = await Post.findAll({
            where:{
                createdAt: createdAt
            }
        });
        if(!post) return res.status(404).json({msg: "Data tidak ditemukan"});
        let response;
        if(req.role === "admin"){
            response = await Post.findAll({
                attributes:['id', 'uuid','love', 'sadness', 'anger', 'happiness', 'disgust', 'optimism',
                'art_id', 'journal', 'createdAt'],
                where:{
                    createdAt: createdAt
                },
                include:[{
                    model: User,
                    attributes:['name','email']
                }]
            });
        }else{
            response = await Post.findOne({
                attributes:['id', 'uuid','love', 'sadness', 'anger', 'happiness', 'disgust', 'optimism',
                'art_id', 'journal', 'createdAt'],
                where:{
                    [Op.and]:[{createdAt: createdAt}, {userId: req.userId}]
                },
                include:[{
                    model: User,
                    attributes:['name','email']
                }]
            });
        }
        res.status(200).json(response);
    } catch (error) {
        res.status(500).json({msg: error.message});
    }
}


export const getPostById = async(req, res) =>{
    try {
        const post = await Post.findOne({
            where:{
                id: req.params.id
            }
        });
        if(!post) return res.status(404).json({msg: "Data tidak ditemukan"});
        let response;
        if(req.role === "admin"){
            response = await Post.findOne({
                attributes:['id', 'uuid','love', 'sadness', 'anger', 'happiness', 'disgust', 'optimism',
                'art_id', 'journal', 'createdAt'],
                where:{
                    id: post.id
                },
                include:[{
                    model: User,
                    attributes:['name','email']
                }]
            });
        }else{
            response = await Post.findOne({
                attributes:['id', 'uuid','love', 'sadness', 'anger', 'happiness', 'disgust', 'optimism',
                'art_id', 'journal', 'createdAt'],
                where:{
                    [Op.and]:[{id: post.id}, {userId: req.userId}]
                },
                include:[{
                    model: User,
                    attributes:['name','email']
                }]
            });
        }
        res.status(200).json(response);
    } catch (error) {
        res.status(500).json({msg: error.message});
    }
}


export const createPost = async(req, res) =>{
    let today = new Date();

    const options = {
        timeZone: 'Asia/Jakarta', // Set the timezone to GMT+7
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
      };

    const formattedToday = today.toLocaleString('en-GB', options).replace(/\//g, '-');
    const {love, sadness, anger, happiness, disgust, optimism, art_id, journal} = req.body;
    try {
        await Post.create({
            createdAt: formattedToday,
            love: love,
            sadness : sadness,
            anger: anger,
            happiness: happiness,
            disgust: disgust,
            optimism: optimism,
            art_id: art_id,
            journal: journal,
            userId: req.userId
        });
        res.status(201).json({msg: "Post Created Successfuly"});
    } catch (error) {
        res.status(500).json({msg: error.message});
    }
}