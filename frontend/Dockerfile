FROM alpine:3.19

# Install Node.js and npm
RUN apk update && apk add --no-cache nodejs npm

# Install Angular CLI globally (optional if you're using a local version in your project)
RUN npm install -g @angular/cli

# Set the working directory
WORKDIR /app

# Copy your project files into the Docker image
COPY . .

# Install project dependencies
RUN npm install

# The command to start your application
CMD ["npm", "start"]
