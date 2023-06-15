# Painthings

Painthings is a mobile application designed to support individuals in exploring and processing their emotions through a **combination** of **art** and **journaling**. The app offers a unique and meaningful experience by allowing users to search for paintings or artworks based on specific emotions they are feeling. These selected artworks serve as prompts for journaling, helping users delve deeper into their *emotions* and *express* themselves through **writing**.

With Painthings, users can create a **digital diary** where they can save their journal entries, creating a personal record of their emotional journey. The app aims to provide accessible emotional **well-being** resources by harnessing the therapeutic benefits of art therapy and expressive writing.


## Description

Painthings is a [BANGKIT 2023 by Google, GoTo and Traveloka](https://grow.google/intl/id_id/bangkit/) Capstone Project. We're from team **C23-PS465** consisting of six members:
1. [Machine Learning](https://grow.google/intl/id_id/bangkit/?tab=machine-learning) - **M181DSX0133** - Mochamad Thariq Zahir Abdillah – Universitas Indonesia
2. [Machine Learning](https://grow.google/intl/id_id/bangkit/?tab=machine-learning) - **M181DSX3215** – Muhammad Rafly Januar – Universitas Indonesia
3. [Cloud Computing](https://grow.google/intl/id_id/bangkit/?tab=cloud-computing) - **C038DSX0612** – Satrio Kamil Widhiwoso – Institut Teknologi Sepuluh Nopember
4. [Cloud Computing](https://grow.google/intl/id_id/bangkit/?tab=cloud-computing) - **C360DSX3415** - Ramadhan Joema Mutsu – Telkom University
5. [Mobile Development](https://grow.google/intl/id_id/bangkit/?tab=mobile-development) - **A181DSX1154** - Setasena Randata Ramadanie – Universitas Indonesia
6. [Mobile Development](https://grow.google/intl/id_id/bangkit/?tab=mobile-development) - **A151DSX3594** – Ariyo Tejo Sumarto – Universitas Brawijaya

According to our project plan, we have completed the development of the Android app functionality with [WikiArt Dataset]([http://saifmohammad.com/WebPages/wikiartemotions.html](http://saifmohammad.com/WebPages/wikiartemotions.html)). Here's the summary of our progress in each learning path:

|Learning Path|Completion Status|
|---|---|
|Machine Learning|100% Complete |
|Mobile Development|100% Complete |
|Cloud Computing|100% Complete |

### Learning Path Details

#### Machine Learning

In the Machine Learning learning path, we focused on building clustering models using the TensorFlow library and Scikit-Learn library. We utilized Flask to deploy the model and performed data preprocessing tasks such as normalization for the dataset and feature selection.

#### Mobile Development

For the Mobile Development learning path, we successfully implemented all planned features in the Painthings Android app. We utilized Retrofit for seamless HTTP requests, integrated Glide for efficient image loading from the internet, and incorporated shared element animations to enhance the user experience.

#### Cloud Computing

In the Cloud Computing learning path, we created APIs for user authentication, posts, and choosing paintings. We deployed the backend service and machine learning models to the Google Cloud Platform using App Engine with the help of Flask.



## Installation

### Cloud Computing
### Machine Learning

To install and run our machine learning model, please follow the steps below:
1. Clone the Painthings repository by running the following command in your terminal:

```bash
git clone https://github.com/setasenarandata/painthings.git
```

2. Open your IDE and navigate to File > Open.
3. Select the "painthings/ml" directory from the cloned repository.
4. Install all the requirements by run "pip install -r requirements.txt" on your terminal.
5. Click on the "Run" button in yout IDE to deploy the model on your device.
6. Wait for the link to appear in your terminal and add '/predict' at the end of the link to use the machine learning model endpoint

#### Installation Steps:

### Mobile Development

To install and run our Android app, please follow the steps below:

#### System Requirements

- Android Studio (latest version)
- Android device or emulator with Pixel 4 Android 13.0, API Level 33

#### Installation Steps:

1. Clone the Painthings repository by running the following command in your terminal:

```bash
git clone https://github.com/setasenarandata/painthings.git
```

2. Open Android Studio and navigate to File > Open.
3. Select the "painthings/android" directory from the cloned repository.
4. Wait for Android Studio to finish importing and building the app.
5. Connect your Android device or launch an emulator with Pixel 4 Android 13.0, API Level 33.
6. Click on the "Run" button in Android Studio to deploy the app on your device or emulator.
7. Wait for the app to install and launch.

Alternatively, if you prefer not to build the app from the source code, we also provide an APK file for easy installation. Simply download the APK file and install it on your Android device.

Please note that you may need to enable "Unknown sources" in your device's settings to install the APK file.

Now you're ready to explore Painthings and enjoy its features!


## Usage

Our final deliverables is a native Android application. After you've managed to install or run the app in your device or emulator, you can register and login to Painthings. Simple right?


## API Reference

-


## Acknowledgements
We would like to express our sincere gratitude to [BANGKIT 2023 by Google, GoTo, and Traveloka](https://grow.google/intl/id_id/bangkit/) for providing us with an incredible opportunity to enhance our skills and knowledge. We are immensely grateful for the support and guidance we received throughout this capstone project.

We extend our heartfelt thanks to our mentors, [Rezki Trianto](https://www.linkedin.com/in/rezkitrianto) and [Eldho Rizcky Al Risyad](https://www.linkedin.com/in/eldhorizcky), for their invaluable expertise and continuous assistance. Their mentorship played a pivotal role in the successful completion of this project.


## Resources
### Cloud Computing
- [NodeJS](https://nodejs.org/en) as the runtime environment for our server-side application
- [ExpressJS](https://expressjs.com/) to develop our RESTful APIs
- [GCP](https://cloud.google.com/) to deploy our backend services and machine learning models
- [Coursera](https://www.coursera.org/) as our learning platform
- [Dicoding](https://www.dicoding.com/) as our learning platform
- [GCSB](https://www.cloudskillsboost.google/journeys) as our learning platform
- [Postman](https://www.postman.com/) as a tool for API development and testing
- [MySQL](https://dev.mysql.com/) as our relational database management system
- [XAMPP](https://www.apachefriends.org/)  as our local development environment

### Machine Learning
- [Coursera](https://www.coursera.org/) as our learning platform
- [Python](https://www.python.org/) as our programming languge
- [Google Colab](https://colab.research.google.com/) as our IDE
- [Tensorflow](https://www.tensorflow.org/) for data preproccessing
- [Scikit-learn](https://scikit-learn.org/stable/) for model clustering
- [Flask](https://flask.palletsprojects.com/en/2.3.x/) for model deployment
- [Pandas](https://pandas.pydata.org/docs/index.html) to load datasets
  
### Mobile Development
- [Dicoding](https://www.dicoding.com/) as our learning platform
- [Figma](https://figma.com) as our main Designing Tools
- [Android Studio](https://developer.android.com/studio) as our IDE
- [Kotlin](https://kotlinlang.org/) as our Programming Language
- [Glide](https://github.com/bumptech/glide) as our Image Loading and Caching
- [Retrofit](https://square.github.io/retrofit/) as our main HTTP Requests Library
- [PopupBarChart](https://github.com/JustinGeorgeJoseph/PopupBarChart) to create and animate Bar Charts
- [StyleableToast](https://github.com/Muddz/StyleableToast) to create styleable toast
- [coil-kt](https://coil-kt.github.io/coil/) as our coroutines image loader


## Roadmap

Outline your future plans for the project, including upcoming features and enhancements.

Feel free to modify this template to suit your project's specific needs. Add additional sections or rearrange them as necessary.

Remember to keep the README file up to date as your project evolves.
