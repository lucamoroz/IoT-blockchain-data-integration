import json


class BasePublisher:
    def publish(self, data: dict):
        print(json.dumps(data, sort_keys=True, indent=4))
