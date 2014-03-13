from evernote.api.client import EvernoteClient

dev_token = 'e'
client = EvernoteClient(token=dev_token)
userStore = client.get_user_store()
user = userStore.getUser()
print user.username