// next.config.js
module.exports = {
    async rewrites() {
        return [
          {
            source: '/:path*',
            destination: 'http://localhost:8080/:path*',
          },
        ]
      },
  };