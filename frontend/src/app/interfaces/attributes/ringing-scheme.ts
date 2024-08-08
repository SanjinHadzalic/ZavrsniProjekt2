export interface RingingScheme {
    id: number;
    code: string;
    country: string;
    centre: string;
    euring: boolean;
    current: boolean;
    dateUpdated: Date;
    notes: string;
}
