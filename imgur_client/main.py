import argparse
import os
import logging
from imgur_client import ImgurClient, download_imgur_image


def _read_cache(base_dir):
    dirs = [o for o in os.listdir(base_dir) if os.path.isdir(os.path.join(base_dir, o))]
    res = {}
    for d in dirs:
        path = os.path.join(base_dir, d)
        res[d] = [os.path.splitext(p)[0] for p in os.listdir(path)]
    return res


def main():
    args = argparse.ArgumentParser()
    args.add_argument("-t", "--tag", help="Tag or comma separated list of tags to fetch", required=True)
    args.add_argument("-d", "--base_dir", help="Base directory for image storage", required=True)
    args.add_argument("-v", "--verbose", action="store_true")
    args = args.parse_args()

    if args.verbose:
        logging.basicConfig(level=logging.DEBUG)
        logging.debug("Arguments:")
        logging.debug("-t {}".format(args.tag))
        logging.debug("-d {}".format(args.base_dir))
    else:
        logging.basicConfig(level=logging.INFO)

    if not os.path.isdir(args.base_dir):
        raise FileNotFoundError("{} is not a directory".format(args.base_dir))

    logging.debug("Loading cache...")
    cache = _read_cache(args.base_dir)
    logging.debug("Found cache for:")
    for tag in cache:
        logging.debug("{}: {} entries".format(tag, len(cache[tag])))

    path = os.path.join(args.base_dir, args.tag)
    if args.tag not in cache:
        if not os.path.isdir(path):
            logging.info("No cache for tag {}, creating directory for this tag".format(args.tag))
            os.mkdir(path)
        else:
            logging.info("No cache for tag {}, but cache directry exists".format(args.tag))

    logging.debug("Initializing Imgur client...")
    imgur_client = ImgurClient()
    logging.debug("Fetching images for tag {}".format(args.tag))
    images = imgur_client.get_images_for_tag(args.tag)

    for image in images:
        if image['id'] not in cache[args.tag]:
            logging.info("Downloading new image {} for tag {}".format(image['name'], args.tag))
            download_imgur_image(image, destination=os.path.join(path, image['name']))

    logging.info("My job is done")


if __name__ == '__main__':
    main()
