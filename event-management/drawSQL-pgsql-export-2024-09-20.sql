CREATE TABLE "Role"(
    "id" UUID NOT NULL,
    "name" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "Role" ADD PRIMARY KEY("id");
CREATE TABLE "Event"(
    "id" UUID NOT NULL,
    "title" VARCHAR(255) NOT NULL,
    "description" VARCHAR(255) NOT NULL,
    "location" VARCHAR(255) NOT NULL,
    "date" VARCHAR(255) NOT NULL,
    "organizer_id" UUID NOT NULL
);
ALTER TABLE
    "Event" ADD PRIMARY KEY("id");
CREATE INDEX "event_organizer_id_index" ON
    "Event"("organizer_id");
CREATE TABLE "User"(
    "id" UUID NOT NULL,
    "username" VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "User" ADD PRIMARY KEY("id");
CREATE TABLE "user_roles"(
    "user_id" UUID NOT NULL,
    "role_id" UUID NOT NULL
);
CREATE INDEX "user_roles_user_id_index" ON
    "user_roles"("user_id");
CREATE INDEX "user_roles_role_id_index" ON
    "user_roles"("role_id");
ALTER TABLE
    "user_roles" ADD CONSTRAINT "user_roles_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "User"("id");
ALTER TABLE
    "user_roles" ADD CONSTRAINT "user_roles_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "Role"("id");
ALTER TABLE
    "Event" ADD CONSTRAINT "event_organizer_id_foreign" FOREIGN KEY("organizer_id") REFERENCES "User"("id");