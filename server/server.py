"""Server application."""
import flask
import uuid
import random

app = flask.Flask(__name__)

# Test services data
services_data = [
    {
        'name': 'Food Truck',
        'latitude': 88.9,
        'longitude': 67.9,
    },
    {
        'name': 'Delivery Driver',
        'latitude': 88.9,
        'longitude': 100.2,
    },
    {
        'name': 'Carpenter',
        'latitude': 10.9,
        'longitude': 44.9,
    },
    {
        'name': 'Cleaning Company',
        'latitude': 22.0,
        'longitude': 78.0
    },
]

@app.route('/services')
def services():
    """Services route for getting all services."""
    return flask.json.jsonify(services_data)

@app.route('/services/<int:service_id>', methods=('get', 'post'))
def service(service_id):
    """Single service endpoint."""
    # TODO
