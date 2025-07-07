# Base image
FROM archlinux:base-20240825.0.257728

# Arguments
ARG TIMEZONE="Europe/Zurich"

# Set the timezone in its different configuration files
RUN ln -s /usr/share/zoneinfo/${TIMEZONE} /etc/localtime && echo "${TIMEZONE}" > /etc/timezone

# Command to run
CMD ["date"]
