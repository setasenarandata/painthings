import Post from "../models/PostModel.js";
import User from "../models/UserModel.js";
import {Op} from "sequelize";

export const getPosts = async (req, res) =>{
    try {
        let response;
        if(req.role === "admin"){
            response = await Post.findAll({
                attributes:['uuid','love', 'sad', 'anger', 'happiness','art_id', 'createdAt'],
                include:[{
                    model: User,
                    attributes:['name','email']
                }]
            });
        }else{
            response = await Post.findAll({
                attributes:['uuid','love', 'sad', 'anger', 'happiness','art_id', 'createdAt'],
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
                attributes:['uuid','love', 'sad', 'anger', 'happiness','art_id', 'createdAt'],
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
                attributes:['uuid','love', 'sad', 'anger', 'happiness','art_id', 'createdAt'],
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
    const date = new Date();
    let now = date.toString();
    const {name, love, sad, anger, happiness} = req.body;
    try {
        await Post.create({
            name: name,
            createdAt: now,
            love: love,
            sad : sad,
            anger: anger,
            happiness: happiness,
            userId: req.userId
        });
        res.status(201).json({msg: "Post Created Successfuly"});
    } catch (error) {
        res.status(500).json({msg: error.message});
    }
}

export const updatePost = async(req, res) =>{
    try {
        const post = await Post.findOne({
            where:{
                uuid: req.params.id
            }
        });
        if(!post) return res.status(404).json({msg: "Data tidak ditemukan"});
        const {name, price} = req.body;
        if(req.role === "admin"){
            await Post.update({name, price},{
                where:{
                    id: post.id
                }
            });
        }else{
            if(req.userId !== post.userId) return res.status(403).json({msg: "Akses terlarang"});
            await Post.update({name, price},{
                where:{
                    [Op.and]:[{id: post.id}, {userId: req.userId}]
                }
            });
        }
        res.status(200).json({msg: "Post updated successfuly"});
    } catch (error) {
        res.status(500).json({msg: error.message});
    }
}

export const deletePost = async(req, res) =>{
    try {
        const post = await Post.findOne({
            where:{
                uuid: req.params.id
            }
        });
        if(!post) return res.status(404).json({msg: "Data tidak ditemukan"});
        const {name, price} = req.body;
        if(req.role === "admin"){
            await Post.destroy({
                where:{
                    id: post.id
                }
            });
        }else{
            if(req.userId !== post.userId) return res.status(403).json({msg: "Akses terlarang"});
            await Post.destroy({
                where:{
                    [Op.and]:[{id: post.id}, {userId: req.userId}]
                }
            });
        }
        res.status(200).json({msg: "Post deleted successfuly"});
    } catch (error) {
        res.status(500).json({msg: error.message});
    }
}