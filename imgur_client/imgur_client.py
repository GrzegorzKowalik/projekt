from imgurpython import ImgurClient as ic
from PIL import Image

import requests
import io
import os


def download_imgur_image(image, destination=None):
    response = requests.get(image['link'])
    if response.status_code == 200:
        data = response.content
        img = Image.open(io.BytesIO(data))
        if destination:
            img.save(destination)
        else:
            return img
    else:
        raise RuntimeError("Response from Requests has code {}".format(response.status_code))


class ImgurClient:
    def __init__(self):
        if "IMGUR_ID" not in os.environ or "IMGUR_SECRET" not in os.environ:
            raise RuntimeError("Credentials for Imgur API not found in environment variables")
        client_id = os.environ['IMGUR_ID']
        client_secret = os.environ['IMGUR_SECRET']

        self.client = ic(client_id, client_secret)

    def get_images_for_tag(self, tag):
        items = self.client.gallery_tag(tag).items

        images = []
        for item in items:
            if hasattr(item, "images"):
                for image in item.images:
                    if image['type'] in ['image/jpeg', 'image/png']:
                        image['name'] = image['link'].split('/')[-1]
                        images.append(image)
        return images
