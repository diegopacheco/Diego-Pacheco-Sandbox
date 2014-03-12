from evernote.api.client import EvernoteClient

dev_token = 'token'
client = EvernoteClient(token=dev_token)
userStore = client.get_user_store()
user = userStore.getUser()
print user.username