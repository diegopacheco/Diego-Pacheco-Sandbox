import httpx

r = httpx.get('https://www.example.org/')
print(r)

print("Status Code " + str(r.status_code))
print("Header Content-Type: " + str(r.headers['content-type']))
print("Body: " + str(len(r.text)) + " size")