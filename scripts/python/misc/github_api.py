from pygithub3 import Github

user = 'u'
gh = Github(login=user, password='p')

users = gh.users.get()
guser = gh.users.get(user)

print 'Users: ' + str(users)
print 'User: ' + str(guser)

repos = gh.repos.list().all()
repos2 = gh.repos.list(user).all()

print "Repos: " + str(repos)
print "Repos: " + str(repos2)