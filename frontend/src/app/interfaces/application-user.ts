import { UserRole } from "./user-role";

export interface ApplicationUser {
    id: number;
    username: string;
    firstname: string;
    lastname: string;
    email: string;
    password: string;
    roles: UserRole[];
}
