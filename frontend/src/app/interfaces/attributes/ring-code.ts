import { ApplicationUser } from "../application-user";

export interface RingCode {
    id: number;
    code: string;
    appUser: ApplicationUser
}
