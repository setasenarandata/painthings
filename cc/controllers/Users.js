import User from "../models/UserModel.js";
import argon2 from "argon2";

export const getUsers = async(req, res) =>{
    try {
        const response = await User.findAll({
            attributes:['uuid','name','email','birthdate','role']
        });
        res.status(200).json(response);
    } catch (error) {
        res.status(500).json({msg: error.message});
    }
}

export const getUserById = async(req, res) =>{
    try {
        const response = await User.findOne({
            attributes:['uuid','name','email','birthdate','role'],
            where: {
                uuid: req.params.id
            }
        });
        res.status(200).json(response);
    } catch (error) {
        res.status(500).json({msg: error.message});
    }
}

export const createUser = async(req, res) =>{
    const {name, email, password, birthdate} = req.body;
    const hashPassword = await argon2.hash(password);
    try {
        const existingUser = await User.findOne({
            where:{
                email:email
            }
        });
        if (existingUser) {
          // If the email is already used, return an error message
          return res.status(400).json({ msg: "Email sudah digunakan" });
        }

        await User.create({
          name: name,
          email: email,
          password: hashPassword,
          birthdate: birthdate,
          role: "user",
        });
        res.status(201).json({msg: "Register Berhasil"});
    } catch (error) {
        res.status(400).json({msg: error.message});
    }
}
