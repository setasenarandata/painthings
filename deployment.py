from flask import Flask,request,jsonify
import numpy as np
import pandas as pd
import pickle
model = pickle.load(open('modelclustering.pkl','rb'))
app = Flask(__name__)
@app.route('/')
def index():
    return 'Hello World'

@app.route('/predict',methods=['POST'])
def predict():
    data = request.get_json()  # Retrieve the JSON data from the request body

    # Extract the values from the JSON data
    love = data.get('love')
    sad = data.get('sadness')
    anger = data.get('anger')
    happiness = data.get('happiness')
    disgust = data.get('disgust')
    optimism = data.get('optimism')

    X_2 = {
       'Art (image+title): love': [love],
       'Art (image+title): sadness': [sad],
       'Art (image+title): anger': [anger],
       'Art (image+title): happiness': [happiness],
       'Art (image+title): disgust': [disgust],
       'Art (image+title): optimism': [optimism],
        }
    df2 = pd.DataFrame(X_2)
    ['love', 'sadness', 'anger', 'happiness','disgust', 'optimism']

    df2

    result = model.predict(df2)
    return jsonify({'hasil clusteting':str(result)})
if __name__ == "_main_":
    app.run()