FROM alpine:edge
RUN apk add --no-cache chromium nodejs
RUN apk add --no-cache grep udev font-adobe-100dpi ttf-freefont
COPY .  /
WORKDIR /

ENTRYPOINT ["/bin/sh"]
ENV CHROME_PATH=/usr/bin/chromium-browser
#RUN $CHROME_PATH --remote-debugging-port=9222 --disable-gpu --headless &
#CMD ["-c", "node /chrome-headless-print.js"]
