import { AccuracyOfCoordinates } from "./accuracy-of-coordinates";

export interface Place {
    id: number;
    name: string;
    country: string;
    regionCode: string;
    latitude: number;
    longitude: number;
    precision: AccuracyOfCoordinates
    notes?: string;
}
