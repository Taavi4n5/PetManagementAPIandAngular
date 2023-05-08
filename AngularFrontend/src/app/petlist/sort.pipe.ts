import {Pipe, PipeTransform} from '@angular/core';
import {Pet} from 'src/app/petInterfaces'
import {compareStrings} from './compareFunction';

@Pipe({
  name: 'sort'
})
export class SortPipe implements PipeTransform {


  transform(value: Pet[], column: string, direction: string): Pet[] {
    if (!value || !column || !direction) {
      return value;
    }

    const sortingOrder = direction === 'asc' ? 1 : -1;
    const sortFunction = (a: any, b: any): number => {
      const valueA = a[column];
      const valueB = b[column];
      return compareStrings(valueA, valueB) * sortingOrder;
    };

    const sortedArray = [...value].sort(sortFunction);

    return sortedArray;
  }
}
