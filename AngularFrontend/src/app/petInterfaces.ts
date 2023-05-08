export interface Pet {
  id: number;
  name?: string;
  code?: number;
  type?: string;
  furColour?: string;
  country?: string;
}

export interface PetWithoutId {
  name: string;
  code: number;
  type?: string;
  furColour?: string;
  country?: string;
}
