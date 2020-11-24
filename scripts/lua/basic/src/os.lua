print(os.date("today is %A, in %B"))

print(os.getenv("HOME"))

function ls(dirname)
    os.execute("ls -lsa " .. dirname)
end
ls("/etc/init.d/cron")