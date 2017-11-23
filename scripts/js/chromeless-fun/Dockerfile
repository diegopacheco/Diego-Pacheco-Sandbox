FROM ubuntu:16.04
RUN apt-get update -y && apt-get install -y chromium-browser curl
RUN curl -sL https://deb.nodesource.com/setup_9.x | bash -
RUN apt-get install -y nodejs
COPY .  /
WORKDIR /
RUN chmod +x /usr/bin/chromium-browser
ENTRYPOINT ["/bin/bash"]
CMD ["-c", "export LIGHTHOUSE_CHROMIUM_PATH=/usr/bin/chromium-browser && /usr/bin/chromium-browser --no-sandbox --remote-debugging-port=9222 --disable-gpu --headless"]
#
# docker exec -it chromeless nodejs chrome-headless-print.js
#
