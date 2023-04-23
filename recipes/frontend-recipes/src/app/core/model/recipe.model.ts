import { Category } from "./cetegory.model"
import { Level } from "./level.model"

export interface Recipe{
  id?: number,
  title: string,
  description: string,
  ingredients: string[],
  time: number
  category: Category,
  level: Level
}
