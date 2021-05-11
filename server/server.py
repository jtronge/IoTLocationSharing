"""Server application."""
import flask
import uuid
import random

app = flask.Flask(__name__)

@app.route('/')
def index():
    # return 'Ciao'
    return flask.json.jsonify(['Ciao', 'mondo', '2'])

def generate_random_services(n=100):
    """Generate random services for testing purposes."""
    services = []
    for i in range(n):
        type_ = uuid.uuid4()
        services.append({
            'name': uuid.uuid4(),
            'type': type_,
            'location': (random.random(), random.random()),
        })
    return services

services = generate_random_services()

@app.route('/services')
def services():
    """Services route for getting all services."""
    return flask.json.jsonify(services)

#@app.route('/services/<service_id:int>', method=['get', 'post'])
#def service():
#    """Single service endpoint."""
#    pass
