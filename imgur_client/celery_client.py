from celery_tasks import save_image
from imgur_client import ImgurClient, download_imgur_image
import os
import logging

if __name__ == '__main__':
    tags = ['cats', 'dogs', 'horses']
    base_pv_path = "/pv"

    logging.basicConfig(level=logging.DEBUG)
    logging.debug("Init ImgurClient")
    imgur_client = ImgurClient()
    if not os.path.isdir(base_pv_path):
        raise RuntimeError("No directory mounted in {}".format(base_pv_path))
    raw_path = os.path.join(base_pv_path, "raw")
    if not os.path.isdir(raw_path):
        logging.debug("Creating dir for raw images")
        os.mkdir(raw_path)

    logging.debug("Listing cache...")
    cache = os.listdir(raw_path)
    logging.debug("Found {} entries in cache".format(len(cache)))
    for tag in tags:
        logging.debug("Fetching images for tag {}".format(tag))
        images = imgur_client.get_images_for_tag(tag)
        logging.debug("Found {} images".format(len(images)))
        for image in images:
            if image['name'] not in cache:
                logging.debug("Image {} not found in cache, downloading...".format(image['name']))
                download_imgur_image(image, destination=os.path.join(raw_path, image['name']))
                logging.debug("Sending image to rabbit")
                save_image.delay(image['name'], tag)
