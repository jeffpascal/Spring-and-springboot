FROM node:14-slim
RUN npm install @angular/cli@latest -g
RUN mkdir -p /app
WORKDIR /app
EXPOSE 4200
CMD ng serve --port 4200 --host 0.0.0.0 --poll 1


