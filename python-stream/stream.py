from flask import Flask, Response
import time

app = Flask(__name__)


@app.route('/api/stream', methods=['GET', 'POST'])
def stream():
    def generate():
        for i in range(20):
            yield f"data: Message {i}\n\n"
            time.sleep(1)

    return Response(generate(), content_type='text/event-stream')


if __name__ == '__main__':
    app.run(debug=False, host='0.0.0.0', port=5000)
