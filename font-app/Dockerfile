FROM node:14-slim
RUN npm install @angular/cli@latest -g
RUN mkdir -p /home/boilerplate
WORKDIR /home/boilerplate
EXPOSE 4200 49153
CMD ng serve --port 4200 --live-reload-port 49153 --poll 1


