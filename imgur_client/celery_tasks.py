import os
from PIL import Image
from celery import Celery

rabbit_host = os.environ['RABBIT_MQ_SVC_SERVICE_HOST']
app = Celery('imgur_client', broker='pyamqp://guest@{}//'.format(rabbit_host))

base_target_directory = "/pv"
raw_directory = "/pv/raw"


@app.task
def save_image(image_name, label):
    raw_file_path = os.path.join(raw_directory, image_name)
    target_path = os.path.join(base_target_directory, label, image_name)
    target_dir = os.path.join(base_target_directory, label)
    if not os.path.isdir(target_dir):
        os.mkdir(target_dir)
    image = Image.open(raw_file_path)
    image.save(target_path)
